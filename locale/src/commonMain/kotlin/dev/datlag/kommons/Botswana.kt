package dev.datlag.kommons


data object Botswana : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("BW")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("BWA")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(72)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(267)
}