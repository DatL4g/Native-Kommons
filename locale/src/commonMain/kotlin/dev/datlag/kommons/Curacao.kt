package dev.datlag.kommons


data object Curacao : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("CW")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("CUW")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(531)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(599)
}