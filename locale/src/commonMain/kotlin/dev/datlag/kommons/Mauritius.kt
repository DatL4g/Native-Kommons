package dev.datlag.kommons


data object Mauritius : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("MU")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("MUS")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(480)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(230)
}