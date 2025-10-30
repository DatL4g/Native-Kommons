package dev.datlag.kommons


data object Pitcairn : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("PN")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("PCN")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(612)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(64)
}